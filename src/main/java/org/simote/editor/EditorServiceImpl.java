package org.simote.editor;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.simote.domain.content.Chapter;
import org.simote.domain.content.Creative;
import org.simote.domain.content.Tag;
import org.simote.repository.CreativeRepository;
import org.simote.repository.TagRepository;
import org.simote.service.MessageByLocaleService;
import org.simote.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorServiceImpl implements EditorService {

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private CreativeRepository creativeRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	
	@Autowired
	private MessageByLocaleService messageByLocaleService;
	
	
	@Override
	public Creative convertFromJsonToJpaCreative(JsonCreative jsonCreative ) {
		Creative creative = new Creative();
		
		creative.setAuthor( securityService.getLoggedInUser() );
		
		
		creative.setChapters( convertJsonChaptersToJpa( creative, jsonCreative.getChapters() ) );
		
		creative.setTags( convertJsonTagsToJpa( creative, jsonCreative.getTags() ) );

		Timestamp timestamp = new java.sql.Timestamp( Calendar.getInstance().getTimeInMillis() );
		
		creative.setCreated( timestamp );
		creative.setEdited( timestamp );
		
		creative.setDescription(jsonCreative.getDescription());
		creative.setName(jsonCreative.getName());
		creative.setRating(0);
		creative.setViewed(0);
		
		return creative;
	}

	private Set<Tag> convertJsonTagsToJpa( Creative parentCreative, Set<JsonTag> tags) {
		if( ( tags == null ) || tags.isEmpty() ) return new HashSet<Tag>();
		
		Set<Tag> convertedTags = new HashSet<Tag>();
		
		for( JsonTag jsonTag : tags ) {
			List<Tag> t = tagRepository.findByName( jsonTag.getText() );
			if( !t.isEmpty() ) {
				 t.get(0).getCreatives().add(parentCreative);
				//convertedTags.add( t.get(0) );
				continue;
			}
			
			Tag convertedTag = new Tag();
			convertedTag.setAddress( jsonTag.getText() );
			convertedTag.setName( jsonTag.getText() );
			convertedTags.add( convertedTag );
		}
		
		return convertedTags;
	}
	
	private Set<Tag> convertJsonTagsToJpa( Chapter chapter, Set<JsonTag> tags) {
		if( ( tags == null ) || tags.isEmpty() ) return new HashSet<Tag>();
		
		Set<Tag> convertedTags = new HashSet<Tag>();
		
		for( JsonTag jsonTag : tags ) {
			List<Tag> t = tagRepository.findByName( jsonTag.getText() );
			if( !t.isEmpty() ) {
				 t.get(0).getChapters().add(chapter);
				//convertedTags.add( t.get(0) );
				continue;
			}
			
			Tag convertedTag = new Tag();
			convertedTag.setAddress( jsonTag.getText() );
			convertedTag.setName( jsonTag.getText() );
			convertedTags.add( convertedTag );
		}
		
		return convertedTags;
	}
	
	private Set<Chapter> convertJsonChaptersToJpa( Creative parentCreative, Set<JsonChapter> chapters ) {
		Set<Chapter> convertedChapters = new HashSet<Chapter>();
		
		for( JsonChapter chapter : chapters ) {
			Chapter convertedChapter = new Chapter();
			
			convertedChapter.setChapterOrder( chapter.getId() );
			convertedChapter.setContent( chapter.getContent() );
			convertedChapter.setParentCreative( parentCreative );
			convertedChapter.setTitle( chapter.getTitle() );
			convertedChapter.setTags( convertJsonTagsToJpa( convertedChapter, chapter.getTags() ) );
			
			convertedChapters.add( convertedChapter );
		}
		
		return convertedChapters;
	}

	@Override 
	public Alert validate( Creative creative ) {
		Alert alert = new Alert();
		alert.setLevel(AlertLevel.SUCCESS);
		alert.setTitle( "Succces!" );
		alert.setDescription("Your creative has created. Maybe You want to make one more?");
		
		if( creative.getName() == null || creative.getName().isEmpty() ) {
			addError( alert, messageByLocaleService.getMessage("page.editor.error.creativename.empty") );
		}else if( creative.getName().length() > 100 ) {
				addError( alert, messageByLocaleService.getMessage("page.editor.error.creativename.toobig", new Integer[]{100} ) );
			}

		if( creative.getDescription() == null || creative.getDescription().isEmpty() ) {
			addError( alert, "Creative description is epmty" );
		}else if( creative.getDescription().length() > 400 ) {
			addError( alert, messageByLocaleService.getMessage("page.editor.error.description.toobig", new Integer[]{400} ) );
		}
		/*
		if( creative.getTags().size() < 2  ) {
			addError( alert, "Creative must have at least two tags" );
		}*/
		
		if( creative.getChapters().isEmpty() ) {
			addError( alert, messageByLocaleService.getMessage( "page.editor.error.nochapters" ) );
		}
		
		for( Chapter ch : creative.getChapters() ) {
			if( ch.getContent().isEmpty() || ch.getContent() == null ) {
				addError( alert, messageByLocaleService.getMessage( "page.editor.error.chapter.nocontent" ) );
			}
			if( ch.getTitle().isEmpty() || ch.getTitle() == null ) {
				addError( alert, messageByLocaleService.getMessage( "page.editor.error.chapter.title.empty" ) );
			}
			/*
			if( ch.getTags().size() < 2 ) {
				for( Tag t : ch.getTags() ) 
				Logger.getAnonymousLogger().warning( t.getName() );
				addError( alert, "The chapter #" + ch.getChapterOrder() + " must have at least two tags" );
			}*/
		}
		
		/*
		if( !alert.hasErrors() ) {
			for( Tag t : tags ) {
				 creative.getTags();
			}
			tagRepository.saveAndFlush();
		}
		*/
		
		return alert;
	}
	
	private void addError( Alert alert, String message ) {
		alert.setLevel(AlertLevel.DANGER);
		alert.setTitle("Oh snap!");
		alert.setDescription("Something went wrong.");
		alert.getMessages().add(message);
		alert.hasErrors = true;
	}
	
	@Override
	public void saveAndFlush(Creative creative) {
		creativeRepository.saveAndFlush( creative );
	}


}
