package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.mbean.model.LoggedInUserModel;
import hu.ulyssys.java.course.maven.mbean.model.LoginModel;
import hu.ulyssys.java.course.maven.service.AppUserService;
import org.primefaces.PrimeFaces;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginRequestBean {
    private LoginModel model = new LoginModel();

    @Inject
    private LoggedInUserBean bean;

    @Inject
    private AppUserService userService;

    public void doLogin() {

        try {
            //Ha sikeres a login
            AppUser appUser = userService.findByUsername(model.getUsername());
            if (appUser == null) {
                throw new SecurityException("Nem létező felhasználó");
            }

            if (!BCrypt.checkpw(model.getPassword(), appUser.getPasswordHash())) {
                throw new SecurityException("Nem megfelelő jelszó");

            }
            LoggedInUserModel loggedInUserModel = new LoggedInUserModel();
            loggedInUserModel.setUsername(appUser.getUsername());
            loggedInUserModel.setId(appUser.getId());
            loggedInUserModel.setRole(appUser.getRole());
            bean.setModel(loggedInUserModel);
            PrimeFaces.current().executeScript("PF('loginDialog').hide()");
            //Akkor  sessionbe beállítjuk a usert reprezentáló modelt.
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "sikertelen bejelentkezés", ""));
        }


    }

    public void doLogout() {
        bean.setModel(null);
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }
}
