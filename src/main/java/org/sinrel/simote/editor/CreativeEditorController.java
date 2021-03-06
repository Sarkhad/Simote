package org.sinrel.simote.editor;

import org.sinrel.simote.domain.content.Creative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreativeEditorController {
	
	@Autowired
	private EditorService editorService;
	
	@GetMapping( "/personal/editor" )
	public String editorPage() {
		return "personal/editor";
	}

	@RequestMapping( value = "/personal/editor/create", method = RequestMethod.POST )
	public @ResponseBody Alert verifyAndPostCreative( @RequestBody JsonCreative jsonCreative ) {
		Creative creative = editorService.convertFromJsonToJpaCreative(jsonCreative);
		
		Alert alert = editorService.validate(creative);
		
		if( alert.getLevel() == AlertLevel.SUCCESS ) {
			editorService.saveAndFlush( creative );
		}
		return alert;
	}
	
}
