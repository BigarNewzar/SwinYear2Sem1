/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import entity.MyuserDTO;
import java.util.Date;
import java.util.Properties;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import session.MyuserFacadeRemote;

/**
 *
 * @author User
 */
@Named(value = "myuserManagedBean")
@RequestScoped
public class MyuserManagedBean {

    @javax.ejb.EJB
    private MyuserFacadeRemote myuserFacade;

    private String userid;
    private String name;
    private String password;
    private String cPassword; // for confirmed password field
    private String email;
    private String phone;
    private String address;
    private String secQn;
    private String secAns;

    public MyuserManagedBean() {
    }

    /*
* add a user to the database
* @return "success" if the add operation is successful
* "failure" otherwise
     */
    public String addUser() {
        String result = "failure";
        /*
 * are all data entered valid?
 * and password the same as cPassword (case sensitive)
 * before calling the façade’s createRecord() method
         */
        if (isValidUserid(userid) && isValidName(name)
                && isValidPassword(password) && isValidPassword(cPassword)
                && isValidEmail(email) && isValidPhone(phone)
                && isValidAddress(address) && isValidSecQn(secQn)
                && isValidSecAns(secAns) && password.equals(cPassword)) {
            MyuserDTO myuserDTO = new MyuserDTO(userid, name,
                    password, email, phone, address, secQn, secAns);
            if (myuserFacade.createRecord(myuserDTO)) {
                result = "success";
            }
        }
        return result;
    }

    public String findUser() {
        String result = "failure";
        /* * if id valid then call facade's userid         */
        if (isValidUserid(userid)) {
            if (myuserFacade.getRecord(userid) != null) {
                result = "success";

            }

        }
        return result;
    }

    public String editUser() {
        String result = "failure";
        /* * if id valid then call facade's userid         */
        if (isValidUserid(userid) && isValidName(name)
                && isValidPassword(password) && isValidPassword(cPassword)
                && isValidEmail(email) && isValidPhone(phone)
                && isValidAddress(address) && isValidSecQn(secQn)
                && isValidSecAns(secAns) && password.equals(cPassword)) {
            MyuserDTO myuserDTO = new MyuserDTO(userid, name,
                    password, email, phone, address, secQn, secAns);
            if (myuserFacade.updateRecord(myuserDTO)) {
                this.sendemail();
                //had to shut it down for now. The rest part works, but adding this part cause the browser to show wierd errors. ask the tutor for help
                //also ask him if we have to do for delete and view records too although it is only saying to do edit user for P
                //and to just set regex protection for the add user part in C level task
                result = "success";
            }

            // this.sendemail();
            /* {
                if (!sendemail()) {
                    result = "failure";
                    System.out.println("email cant be sent");
                } else {
                    System.out.println("email can be sent");
                }
            }*/
        }
        return result;
    }

    /* Some basic checking, complicated checking can be done later
* not a good way of doing this
* Should use JSF’s validator method to do this – left as C task
     */
    //reference: https://docs.oracle.com/javaee/7/tutorial/jsf-custom011.htm
    //note: in the code if password is not inputted properly, it will consider password as null. thus if password doesnt follow criteria, even if password is same as cpassword, it will still consider it as not same!
    public void validatePasswordCorrect(FacesContext context, UIComponent component, Object value) {
        String cPassword = (String) value;

        UIInput password = (UIInput) component.findComponent("password");
        String password1 = (String) password.getLocalValue();

        //checking to see what happens when password is not following criteria
        System.out.println("Password input: " + password);

        if (password1 == null || cPassword == null || !password1.equals(cPassword)) {
            //reference: https://docs.oracle.com/javaee/5/api/javax/faces/application/FacesMessage.html#FacesMessage(javax.faces.application.FacesMessage.Severity,%20java.lang.String,%20java.lang.String)
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords need to match!", "");

            //just to check stuff
            System.out.println("Password not matched");
            throw new ValidatorException(msg);
        }
    }

    public boolean isValidUserid(String userid) {
        return (userid != null);
    }

    public boolean isValidName(String name) {
        return (name != null);
    }

    public boolean isValidPassword(String password) {
        return (password != null);
    }

    public boolean isValidEmail(String email) {
        return (email != null);
    }

    public boolean isValidPhone(String phone) {
        return (phone != null);
    }

    public boolean isValidAddress(String address) {
        return (address != null);
    }

    public boolean isValidSecQn(String secQn) {
        return (secQn != null);
    }

    public boolean isValidSecAns(String secAns) {
        return (secAns != null);
    }

    public MyuserFacadeRemote getMyuserFacade() {
        return myuserFacade;
    }

    public void setMyuserFacade(MyuserFacadeRemote myuserFacade) {
        this.myuserFacade = myuserFacade;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSecQn() {
        return secQn;
    }

    public void setSecQn(String secQn) {
        this.secQn = secQn;
    }

    public String getSecAns() {
        return secAns;
    }

    public void setSecAns(String secAns) {
        this.secAns = secAns;
    }

    public boolean sendemail() {///boolean
        boolean result = false;
        String smtpServer = "smtp.gmail.com";
        String from = "bigarnewzar@gmail.com";
        String to = "elau@swin.edu.au";
        String subject = "Testing from gmail";
        String body = "Hi Edmonds,\nThis is a test!\nRegards,\nEdmonds\n";
        String emailUser = from;
        String Spassword = "RagibTester11366";
        try {
            Properties props = System.getProperties();
            // -- Attaching to default Session, or we could start a new one --
            props.put("mail.smtp.host", smtpServer);
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.auth", true);
            props.put("mail.smtp.starttls.enable", true);
            // -- prepare a password authenticator --
            MyAuthenticator myPA = new MyAuthenticator(emailUser, Spassword); // see MyAuthenticator class
            // get a session
            Session session = Session.getInstance(props, myPA);
            // -- Create a new message --
            Message msg = new MimeMessage(session);
            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            // -- Set the subject and body text --
            msg.setSubject(subject);
            msg.setText(body);
            // -- Set some other header information --
            msg.setHeader("X-Mailer", "Gmail");
            msg.setSentDate(new Date());
            // -- Send the message --
            Transport.send(msg);
            Transport.send(msg, emailUser, Spassword);
            System.out.println("Message sent OK.");

            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

        /*
        String smtpServer = "smtp.gmail.com";
        String from = "bigarnewzar@gmail.com";//////altered this for the ss
        String to = "elau@swin.edu.au";
        String subject = "Testing from gmail";
        String body = "Hi Edmonds,\nThis is a test!\nRegards,\nEdmonds\n";
        String emailUser = from;
        String password = "Shaan01972448030!";//////altered this for the ss
        try {
            Properties props = System.getProperties();
            // -- Attaching to default Session, or we could start a new one --
            props.put("mail.smtp.host", smtpServer);
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.auth", true);
            props.put("mail.smtp.starttls.enable", true);
            // -- prepare a password authenticator --
            MyAuthenticator myPA = new MyAuthenticator(emailUser, password); // see MyAuthenticator class
            // get a session
            Session session = Session.getInstance(props, myPA);
            // -- Create a new message --
            Message msg = new MimeMessage(session);
            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            // -- Set the subject and body text --
            msg.setSubject(subject);
            msg.setText(body);
            // -- Set some other header information --
            msg.setHeader("X-Mailer", "Gmail");
            msg.setSentDate(new Date());
            // -- Send the message --
            Transport.send(msg);
            Transport.send(msg, emailUser, password);
            System.out.println("Message sent OK.");

            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         */
    }

    public PasswordAuthentication getPasswordAuthentication() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
