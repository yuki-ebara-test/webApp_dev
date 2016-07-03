package test;

import java.util.Map;

public class UserInputController extends AbsController {

	@Override
	protected String process(Map<String, String> requeestMap) {

		return "/view/result.html";
	}



}
