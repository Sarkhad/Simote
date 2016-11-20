package org.simote.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LogInForm {

	@NotBlank
	@Size( max = 255 )
	private String name;
	
	
}
