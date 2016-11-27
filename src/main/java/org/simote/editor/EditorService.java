package org.simote.editor;

import org.simote.domain.content.Creative;

public interface EditorService  {
	
	Creative convertFromJsonToJpaCreative( JsonCreative creative );

	void saveAndFlush( Creative creative );

	Alert validate(Creative creative);

}
