/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ImagenFactory;
import View.Interfaz;
import View.JPanelImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user
 */
public class Eventos implements ActionListener {
    Interfaz inter = new Interfaz();
    ImagenFactory IF = new ImagenFactory();
    
    public Eventos(Interfaz inter) {
		this.inter = inter;
                this.inter.ButtonHeadIzq.addActionListener((ActionListener) this);
                this.inter.ButtonHeadDer.addActionListener((ActionListener) this);
                this.inter.ButtonBodyIzq.addActionListener((ActionListener) this);
                this.inter.ButtonBodyDer.addActionListener((ActionListener) this);
                this.inter.ButtonDownload.addActionListener((ActionListener) this);
                
                this.inter.PanelFBase.setOpaque(false);
                this.inter.PanelFBase.setBorder(null);
                this.inter.PanelFBase.setBackground(new Color(0,0,0,0));
                
                this.inter.PanelFHead.setOpaque(false);
                this.inter.PanelFHead.setBorder(null);
                this.inter.PanelFHead.setBackground(new Color(0,0,0,0));
                
                this.inter.PanelFBody.setOpaque(false);
                this.inter.PanelFBody.setBorder(null);
                this.inter.PanelFBody.setBackground(new Color(0,0,0,0));
                
		this.inter.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        // Cambio de cabeza
        if(e.getSource().equals(this.inter.ButtonHeadIzq)) {
            inter.PanelFHead.removeAll();
            JPanelImage head = new JPanelImage(inter.PanelFHead, IF.getImagen("head").returnPathIzq());
            inter.PanelFHead.add(head).repaint();
            inter.PanelFHead.revalidate();
        }
        if(e.getSource().equals(this.inter.ButtonHeadDer)) {
            inter.PanelFHead.removeAll();
            JPanelImage head = new JPanelImage(inter.PanelFHead, IF.getImagen("head").returnPathDer());
            inter.PanelFHead.add(head).repaint();
            inter.PanelFHead.revalidate();
        }
        // Cambio de cuerpo
        if(e.getSource().equals(this.inter.ButtonBodyIzq)) {
            inter.PanelFBody.removeAll();
            JPanelImage body = new JPanelImage(inter.PanelFBody, IF.getImagen("body").returnPathIzq());
            inter.PanelFBody.add(body).repaint();
            inter.PanelFBody.revalidate();
        }
        if(e.getSource().equals(this.inter.ButtonBodyDer)) {
            inter.PanelFBody.removeAll();
            JPanelImage body = new JPanelImage(inter.PanelFBody, IF.getImagen("body").returnPathDer());
            inter.PanelFBody.add(body).repaint();
            inter.PanelFBody.revalidate();
        }
        if(e.getSource().equals(this.inter.ButtonDownload)) {
            try {
                // Obtener las imágenes directamente de los JPanel
                BufferedImage headBufferedImage = new BufferedImage(inter.PanelFHead.getWidth(), inter.PanelFHead.getHeight(), BufferedImage.TYPE_INT_ARGB);
                inter.PanelFHead.paint(headBufferedImage.getGraphics());

                BufferedImage bodyBufferedImage = new BufferedImage(inter.PanelFBody.getWidth(), inter.PanelFBody.getHeight(), BufferedImage.TYPE_INT_ARGB);
                inter.PanelFBody.paint(bodyBufferedImage.getGraphics());

                BufferedImage baseBufferedImage = new BufferedImage(inter.PanelFBase.getWidth(), inter.PanelFBase.getHeight(), BufferedImage.TYPE_INT_ARGB);
                inter.PanelFBase.paint(baseBufferedImage.getGraphics());

                // Combinar las imágenes
                BufferedImage combinedImage = new BufferedImage(baseBufferedImage.getWidth(), baseBufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = combinedImage.createGraphics();
                g.drawImage(bodyBufferedImage, 0, 190, null);
                g.drawImage(headBufferedImage, 0, 0, null);
                g.dispose();

                // Guardar la imagen combinada
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Guardar imagen combinada");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                fileChooser.setFileFilter(filter);
                int userSelection = fileChooser.showSaveDialog(this.inter);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    ImageIO.write(combinedImage, "png", fileToSave);
                    JOptionPane.showMessageDialog(this.inter, "Imagen guardada exitosamente!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this.inter, "Error al guardar la imagen.");
            }
        } 
    }
}
