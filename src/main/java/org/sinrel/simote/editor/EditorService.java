package org.sinrel.simote.editor;

import org.sinrel.simote.domain.content.Creative;

public interface EditorService  {
	
	Creative convertFromJsonToJpaCreative( JsonCreative creative );

	void saveAndFlush( Creative creative );

	Alert validate(Creative creative);

}
