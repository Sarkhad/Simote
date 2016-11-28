package org.sinrel.simote.service;

import java.util.List;
import java.util.Set;

import org.sinrel.simote.domain.content.Chapter;

public interface ChapterService {

	List<Chapter> sortChaptersByOrder( Set<Chapter> chaptersToSort );
	
}
