package cleancode;

import cleancode.pretend.Autowired;
import cleancode.pretend.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManyParamsOOP {
    @Autowired
    private Validator validator;

    public void bizLogic() {
        List<String> errors = new ArrayList<>();
        validator.m1("a",1, errors);
        validator.m2("b",1, errors);
        validator.m3("file.txt", 1L,"ref", errors);
        validator.m4(errors, "a", 1L,5L, "g");
        validator.m5(errors, 1);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }
    }
}
@Service
class Validator {
    @Autowired
	private OtherDependency dep;

    public void m1(String a, int b, List<String> errors) {
        if (a == null) {
            errors.add("a must not be null");
        }
        // stuff
    }
    public void m2(String s, int c, List<String> errors) {
        if (c < 0) {
            errors.add("negative c");
        }
        // stuff
    }
    public void m3(String fileName, long versionId, String reference, List<String> errors) {
        // stuff
    }
    public void m4(List<String> errors, String a, long listId, long recordId, String g) {
        // stuff
    }
    public void m5(List<String> errors, int b) {
        // stuff
    }
}

@Service
class OtherDependency {
}
