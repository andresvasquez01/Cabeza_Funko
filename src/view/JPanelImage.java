package View;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelImage extends JPanel {
    private Image image;
    private int x, y;
    private final String path;
    
    public JPanelImage(JPanel panel, String imagePath){
        this.path = imagePath;
        this.x = panel.getWidth();
        this.y = panel.getHeight();
        this.setSize(x, y);
        ImageIcon icon = new ImageIcon(imagePath);
        image = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
