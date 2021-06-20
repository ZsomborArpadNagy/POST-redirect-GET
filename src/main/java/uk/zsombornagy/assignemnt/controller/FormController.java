package uk.zsombornagy.assignemnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uk.zsombornagy.assignemnt.model.SimpleForm;

import javax.validation.Valid;

@Controller
public class FormController
{

	private static final String VIEW_FORM = "form";
	private static final String VIEW_SUCCESS = "success";
	private static final String URL_FORM = "/form";
	private static final String URL_SUCCESS = "/success";

	@GetMapping(value = URL_FORM)
	public String getFormPage(SimpleForm simpleForm)
	{
		return VIEW_FORM;
	}

	@PostMapping(value = URL_FORM)
	public String postForm(@Valid SimpleForm simpleForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute(simpleForm);
		if (bindingResult.hasErrors())
		{
			redirectAttributes.addFlashAttribute("fieldErrors", bindingResult.getFieldErrors());
			return getRedirectUrl(URL_FORM);
		}
		return getRedirectUrl(URL_SUCCESS);
	}

	@GetMapping(value = URL_SUCCESS)
	public String getSuccessPage(SimpleForm simpleForm)
	{
		return VIEW_SUCCESS;
	}

	private static String getRedirectUrl(final String url)
	{
		return new StringBuilder("redirect:").append(url).toString();
	}
}
