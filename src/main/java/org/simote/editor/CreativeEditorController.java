package org.simote.editor;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.simote.repository.ChapterRepository;
import org.simote.repository.CreativeRepository;
import org.simote.repository.TagRepository;
import org.simote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CreativeEditorController {
	
	@GetMapping( "/personal/editor" )
	public String editorPage() {
		return "personal/editor";
	}
	
	/*
	//TODO always 404 error
	@RequestMapping( value = "/personal/editor/create", method = RequestMethod.POST )
	public @ResponseBody String createCreative() {
		return "{hello: world}";
	}
	*/
	
	//TODO what was planned
	@RequestMapping( value = "/personal/editor/create", method = RequestMethod.POST )
	public @ResponseBody String verifyAndPostCreative( @RequestBody Creative creative ) {
		return "ssss";
	}
	
	//TODO what's works via the form submitting. Not angular's way,
	@RequestMapping(value="/personal/editor", method=RequestMethod.POST)
	public void addOrder( @RequestParam( "creative" ) String json ) {
		Logger.getLogger(getClass()).warn(json);

	    ObjectMapper mapper = new ObjectMapper();

	    try {

	        Creative creativeObj = mapper.readValue(json, Creative.class);
	        for( Chapter ch : creativeObj.getChapters() ) {
	        	for( Tag t :ch.getTags() ) {
	        		Logger.getLogger(getClass()).warn( t.getText() );
	        	}
	        }

	    } catch (JsonGenerationException e) {

	        e.printStackTrace();

	    } catch (JsonMappingException e) {

	        e.printStackTrace();

	    } catch (IOException e) {

	        e.printStackTrace();

	    }

	}
	
	
	/*
	@RequestMapping(value = "/personal/editor/create", method = RequestMethod.POST)
	public @ResponseBody Creative PostService(@RequestBody Creative person) {
		
		return person;
	}*/
		
	//@RequestMapping(value = "/personal/editor/create", method = RequestMethod.POST)
//	public @ResponseBody Person PostService(@RequestBody Person person) {
		
	//	return person;
	//}
	
	
	/*
	@RequestMapping( value = "/personal/editor/create", method = RequestMethod.POST)	
	public  @ResponseBody String saveCompany_JSON( @RequestBody Creative creative )   {	
		Logger.getLogger(getClass()).warn("sdsdsdaasadasakmkads");
		//
		// Code processing the input parameters
		//	
		return "JSON: The company name: " + creative.getName();
	}*/
	/*
	@RequestMapping( value = "/create", method = RequestMethod.POST )
	public @ResponseBody String createCreative( @RequestParam("creative") Creative creative ) {
		
		Logger.getLogger(getClass()).warn("sdsdsdaasadasakmkads");
		/*
		Creative c = new Creative();
		c.setAuthor( securityService.getLoggedInUser() );
		
		c.setName( "Test creative #" + new Random().nextInt( 10 ) );
		Timestamp date = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis() );
		c.setCreated( date );
		c.setEdited( date );
		c.setViewed(new Random().nextInt( 1000 ) + 1);	
		c.setRating( 3.7F );
		
		Chapter chapter = new Chapter();
		chapter.setContent( "Lorem ipsum" + UUID.randomUUID() );
		chapter.setOrder( new Random().nextInt(10) + 1 );
		chapter.setParentCreative( c );
		chapter.setTitle("Test creative chapter " + UUID.randomUUID() );
		
		Chapter chapter2 = new Chapter();
		chapter2.setContent( "Lorem ipsum" + UUID.randomUUID() );
		chapter2.setOrder( new Random().nextInt(10) + 1 );
		chapter2.setParentCreative( c );
		chapter2.setTitle("Test creative chapter " + UUID.randomUUID() );
		
		chapterRepository.saveAndFlush( chapter );
		chapterRepository.saveAndFlush( chapter2 );
		
		c.addChapter( chapter );
		c.addChapter( chapter2 );

		Tag tag = new Tag();
		tag.setAddress( UUID.randomUUID().toString() );
		tag.setName( UUID.randomUUID().toString() );
		
		tagRepository.saveAndFlush(tag);
		
		c.addTag(tag);



		creativeRepository.saveAndFlush( c );
		*/
		//return "pidr";
		//return "redirect:/";
	//}
	
}
