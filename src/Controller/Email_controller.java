
package Controller;

import Model.Email;
import View.pnlConfigEmail;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.String.valueOf;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Kevin
 */
public class Email_controller 
{
    
    
    private static Email emailEmpty = new Email();
    private static Email correoComercio = new Email();
    
    public static void enviarMail(String correoCliente)
    {
       try           
       {      
           
            Email_controller.leerEmailFromFile();
           
           
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = pnlConfigEmail.datosEmail.getDireccion();
            String passwordRemitente = pnlConfigEmail.datosEmail.getContrasenia();
            String correoReceptor = correoCliente;
            
            String asunto = "COMIDA CHINA EL DRAGON - notificación";         
            String mensaje = "<br><b>CONSENTIMIENTO INFORMADO</b></br>"
                    + "<p style=»text-align: justify;»>Conforme a lo dispuesto por la <b>Ley No. 8968, Ley de Protección de la Persona frente al Tratamiento "
                    + "de sus Datos Personales</b> y su Reglamento, autorizo al comercio Comida China El Dragón a que recopile,"
                    + " almacene y procese la información relativa a mis datos personales para conformar el proceso de "
                    + "registro de ventas que su sistema requiere para un adecuado funcionamiento, dicha información podrá "
                    + "ser utilizada en forma confidencial en elaboración de sus reportes y estadísticas internas.</p>";

            
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close(); 

            
            Notificaciones("mailSent");
            
            
        } catch (MessagingException ex) {
            Notificaciones("mailError"+ex.getMessage());
        }catch(NullPointerException e)
        {
           Notificaciones("mailComercioEmpty");
        }
    }
    
    
     
    
    public static void almacenarEmailInFile() throws IOException
    {
        //escribe en el arhivo
        FileOutputStream out = new FileOutputStream("DATOS_EMAIL.txt");
        ObjectOutputStream salida = new ObjectOutputStream(out);
           
        salida.writeObject(pnlConfigEmail.datosEmail);
        salida.flush();   
        Notificaciones("mailSave");
    }
        
    public static void leerEmailFromFile()
    {
        File file = new File("DATOS_EMAIL.txt"); 
        ObjectInputStream entrada;
        try
        {
            if(file.exists())
            {
                entrada = new ObjectInputStream(new FileInputStream("DATOS_EMAIL.txt"));
            
                pnlConfigEmail.datosEmail = (Email) entrada.readObject();
                entrada.close();
                
            }

        } catch (FileNotFoundException  ex) 
        {
            
        }catch (IOException e)
        {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Email_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
            
    public static void eliminarFile()
    {
    
        File file = new File("DATOS_EMAIL.txt"); //System.out.println("archivo no existe");
        if(file.exists() && file.length() != 0)
        {
            file.delete();             
            
            FileOutputStream out;
            try 
            {
                out = new FileOutputStream("DATOS_EMAIL.txt");
                ObjectOutputStream salida = new ObjectOutputStream(out);
           
                salida.writeObject(emailEmpty);
                salida.flush();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Email_controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Email_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }

    }
    
    
    
    
     
//        if (ValidarMail("info@miDominio.com") == true) {
//            System.out.println("El email es valido.");
//        } else {
//            System.out.println("El email NO es valido.");
//        }
// 
//        if (ValidarMail("info@miDo minio.com") == true) {
//            System.out.println("El email es valido.");
//        } else {
//            System.out.println("El email NO es valido.");
//        }
    
 
    public static boolean ValidarMail(String email) {
        // Patron para validar el email
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        //Pattern pattern = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
        //Pattern pattern = Pattern.compile("^(?=[A-Z0-9][A-Z0-9@._%+-]{5,253}+$)[A-Z0-9._%+-]{1,64}+@(?:(?=[A-Z0-9-]{1,63}+\\.)[A-Z0-9]++(?:-[A-Z0-9]++)*+\\.){1,8}+[A-Z]{2,63}+$");        
       // Pattern pattern = Pattern.compile("/^(([^<>()\\[\\]\\\\.,;:\\s@”]+(\\.[^<>()\\[\\]\\\\.,;:\\s@”]+)*)|(“.+”))@((\\[[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}])|(([a-zA-Z\\-0–9]+\\.)+[a-zA-Z]{2,}))$/");
        //Pattern patron = Pattern.compile("/[a-z0-9]+[_a-z0-9\\.-]*[a-z0-9]+@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})/ig");
        
        Matcher comparar = patron.matcher(email);
        return comparar.find();
    }
    
    
    public static void enviarMailConAdjunto(String correoCliente, String numFactura)
    {
      
        try 
        {
            
            Email_controller.leerEmailFromFile();
            
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            
            
            String correoRemitente = pnlConfigEmail.datosEmail.getDireccion();
            String passwordRemitente = pnlConfigEmail.datosEmail.getContrasenia();
            String correoReceptor = correoCliente;

            String asunto = "COMIDA CHINA EL DRAGON - notificación";
            String mensaje = "<br><b>CONSENTIMIENTO INFORMADO</b></br>"
                    + "<p style=»text-align: justify;»>Conforme a lo dispuesto por la <b>Ley No. 8968, Ley de Protección de la Persona frente al Tratamiento "
                    + "de sus Datos Personales</b> y su Reglamento, autorizo al comercio Comida China El Dragón a que recopile,"
                    + " almacene y procese la información relativa a mis datos personales para conformar el proceso de "
                    + "registro de ventas que su sistema requiere para un adecuado funcionamiento, dicha información podrá "
                    + "ser utilizada en forma confidencial en elaboración de sus reportes y estadísticas internas.</p>";

            BodyPart texto = new MimeBodyPart();
            texto.setContent(mensaje, "text/html");

            BodyPart adjunto = new MimeBodyPart();             //JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteCierre.jasper"));                          
            adjunto.setDataHandler(new DataHandler(new FileDataSource("Facturas/".concat(numFactura.concat(".pdf"))))); //"Facturas/".concat(factura.concat(".pdf")
            adjunto.setFileName("Factura_"+numFactura+".pdf");

            MimeMultipart miltiParte = new MimeMultipart();
            miltiParte.addBodyPart(texto);
            miltiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setContent(miltiParte);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            //JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");

        } catch (AddressException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(java.lang.NullPointerException ex)
        {
            Notificaciones("mailComercioEmpty");
        }
    }

    
    
    public static void Notificaciones(String accion)
    {
        switch(accion)
        {
            case "mailSave":
                    new rojerusan.RSNotifyAnimated("", "Correo guardado correctamente", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                 break;
                 
           case "mailEdit":
                    new rojerusan.RSNotifyAnimated("", "Correo guardado correctamente", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                 break;     
                 
            case "passwordIncorrect":
                    new rojerusan.RSNotifyAnimated("", "Las contraseñas ingresadas no son correspondientes", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                break;    
                
            case "mailIncorrect":
                    new rojerusan.RSNotifyAnimated("", "El correo ingresado no es válido", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break; 
                 
            case "mailSent":
                    new rojerusan.RSNotifyAnimated("", "Correo enviado", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                 break;
                
            case "mailError":
                    new rojerusan.RSNotifyAnimated("", "Se presentó un problema al enviar el correo", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                break;
            case "mailErrorSent":
                    new rojerusan.RSNotifyAnimated("", "Se presentó un problema al enviar el correo, la dirección electrónica era inválida", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break;
            case "mailEmpty":
                    new rojerusan.RSNotifyAnimated("", "El cliente no posee un correo vinculado", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                break;
            case "mailComercioEmpty":
                    new rojerusan.RSNotifyAnimated("", "El negocio no posee un correo vinculado", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                break;
                
        } 
        
    }
    
}
