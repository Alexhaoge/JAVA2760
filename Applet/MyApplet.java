import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Image;

/**
 * 需要在%JAVA_HOME%/lib/securiy/java.policy的grant中添加如下：<p>
 * permission java.io.FilePermission  "<<ALL FILES>>" ,  "read,write" ;
 */
public class MyApplet extends Applet implements MouseListener{
    /**
     * My First Applet
     */
    private static final long serialVersionUID = 1L;
    
    private AudioClip clip;
    private Image image;
    private AppletContext context;
    private ArrayList<String> strList;

    @Override
    public void init() {
        context = this.getAppletContext();

        String imageURL = this.getParameter("image");
        try {
            URL url = new URL(this.getDocumentBase(), imageURL);
            image = context.getImage(url);
        } catch(IOException e) {
            e.printStackTrace();
            context.showStatus("Could not load image!");
        }

        String audioURL = this.getParameter("audio");
        try {
            URL url = new URL(this.getDocumentBase(), audioURL);
            clip = context.getAudioClip(url);
        } catch(IOException e) {
            e.printStackTrace();
            context.showStatus("Could not load audio file!");
        }

        addMouseListener(this);
        strList = new ArrayList<>();
        addItem("initializing the applet ");
    }

    @Override
    public void start()
    {
        addItem("starting the applet ");
        if(clip != null) {
            clip.loop();
        }
    }

    @Override
    public void stop()
    {
        addItem("stopping the applet ");
        if(clip != null) {
            clip.stop();
        }
    }

    @Override
    public void destroy() {
        addItem("unloading the applet");
    }

    void addItem(String word) {
        strList.add(word);
        repaint();
    }
 
    @Override
    public void paint(Graphics g) {
        context.showStatus("Displaying image");
        if (image == null) {
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        } else {
            g.drawImage(image, 0, 0, getWidth() - 1, getHeight() - 1, null);
        }
        //display the string inside the rectangle.
        for (int i = 0; i < strList.size(); i++) {
            g.drawString(strList.get(i), 0, 10*i);
        }
    }
 
    public void mouseEntered(MouseEvent event) {
        // do nothing
    }
    public void mouseExited(MouseEvent event) {
        // do nothing
    }
    public void mousePressed(MouseEvent event) {
        // do nothing
    }
    public void mouseReleased(MouseEvent event) {
        // do nothing
    }
    public void mouseClicked(MouseEvent event) {
         addItem("mouse clicked! ");
    }
}