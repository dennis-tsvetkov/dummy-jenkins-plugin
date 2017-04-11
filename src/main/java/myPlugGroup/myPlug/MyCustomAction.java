package myPlugGroup.myPlug;

import java.util.Arrays;
import java.util.Collection;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import net.sf.json.JSONObject;

public class MyCustomAction extends JobProperty<AbstractProject<?, ?>> {


  @DataBoundConstructor
  public MyCustomAction() {
  }

  @Override
  public Collection<? extends Action> getJobActions(AbstractProject<?, ?> job) {
    Action action = new MyAction("MyUrl", "MyCustomAction", "");
    return Arrays.asList(action);
  }

  @Extension
  public static class DescriptorImpl extends JobPropertyDescriptor {
    @Override
    public String getDisplayName() {
      return "My custom plugin";
    }

    @Override
    public MyCustomAction newInstance(StaplerRequest req, JSONObject formData) throws FormException {
      return formData.has("MyPlug")
          ? req.bindJSON(MyCustomAction.class, formData.getJSONObject("MyPlug"))
          : null;
    }
  }

}