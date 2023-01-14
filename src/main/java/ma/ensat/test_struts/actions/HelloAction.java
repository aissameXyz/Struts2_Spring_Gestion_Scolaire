package ma.ensat.test_struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "hello")
@Result(name = "success", location = "/index.jsp")
public class HelloAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
