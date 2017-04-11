package myPlugGroup.myPlug;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.model.Action;

public class MyAction implements Action {
  private String url, text, icon;

  @DataBoundConstructor
  public MyAction(String urlName, String displayName, String iconFileName) {
    this.url = urlName;
    this.text = displayName;
    this.icon = iconFileName;
  }

  public String getUrlName() {
    return url;
  }

  public String getDisplayName() {
    return text;
  }

  public String getIconFileName() {
    return icon;
  }

}
