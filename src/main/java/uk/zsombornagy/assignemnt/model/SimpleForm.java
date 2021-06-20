package uk.zsombornagy.assignemnt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class SimpleForm
{
	@NotBlank(message = "Please provide a text")
	@Size(max = 10, message = "Text should not be more than 10 chars long")
	private String inputText;
}
