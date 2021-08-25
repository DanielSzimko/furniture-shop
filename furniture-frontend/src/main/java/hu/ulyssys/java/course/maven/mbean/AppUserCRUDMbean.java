package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.entity.Farmer;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.FarmerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Date;
import java.util.UUID;

@Named
@ViewScoped
public class AppUserCRUDMbean extends CoreCRUDMbean<AppUser> implements Serializable {


    @Inject
    public AppUserCRUDMbean(AppUserService userService, LoggedInUserBean loggedInUserBean) {
        super(userService);
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság");
        }
    }

    @Override
    protected String dialogName() {
        return "appUserDialog";
    }


    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setPasswordHash(hashPassword(getSelectedEntity().getPasswordHash()));
                getSelectedEntity().setCreatedDate(new Date());
            }
            super.save();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt hashelés közben", ""));
            e.printStackTrace();
        }
    }

    @Override
    protected AppUser initNewEntity() {
        return new AppUser();
    }

    //Bcrypt

    private String hashPassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        return encoder.encode(rawPassword);
    }

  /*  private String hashPassword(String rawPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(rawPassword.toCharArray(), salt, 65536, 128);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = factory.generateSecret(spec).getEncoded();
        return bytesToHex(hash);
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }*/
}
