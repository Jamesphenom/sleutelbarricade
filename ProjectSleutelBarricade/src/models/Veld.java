/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author J_Administrator
 */
public class Veld extends JLabel{
    private Coordinaten myCoordinaten;
    //Soorten type die het veld kan bevatten
    public static enum TYPE {
        MUUR,
        BARRICADE,
        SLEUTEL,
        EINDPUNT,
        OTHER
    };
    private TYPE bevat = TYPE.OTHER;
    private Speler speler = null;
    private int labelWidth;
    private int labelHeight;
    private ImageIcon afbeelding;
    private Object object;
    
    public Veld(Coordinaten coordinaten, TYPE bevat, String object) throws ClassNotFoundException, InstantiationException, IllegalAccessException{      
        this.myCoordinaten = coordinaten;
        this.bevat = bevat;
        this.object = Class.forName(object).newInstance();
    }
    
    public Veld(Coordinaten coordinaten){
        this.myCoordinaten = coordinaten;
        this.bevat = TYPE.OTHER;
    }    
    
    public void moveSpeler(String direction){
        speler.setDirection(direction);
    }
    
    public Object getObject(){
        return this.object;
    }
    
    public void setObject(Object object){
        this.object = object;
    }
    
    public TYPE getBevat() {
        return bevat;
    }

    public void setBevat(TYPE bevat) {
        this.bevat = bevat;
    }
    
    public Coordinaten getMyCoordinaten() {
        return myCoordinaten;
    }

    public void setMyCoordinaten(Coordinaten myCoordinaten) {
        this.myCoordinaten = myCoordinaten;
    }

    public int getLabelWidth() {
        return labelWidth;
    }

    public void setLabelWidth(int width) {
        this.labelWidth = width;
    }

    public int getLabelHeight() {
        return labelHeight;
    }

    public void setLabelHeight(int height) {
        this.labelHeight = height;
    }

    public ImageIcon getAfbeelding() {
        String workingDir = System.getProperty("user.dir");
        //Fix the problem with MAC OS
        if("MAC OS X".equals(System.getProperty("os.name"))) workingDir = System.getProperty("user.home");
        String afbeeldingNaam;
        if(this.isThereAPlayer()){
            afbeeldingNaam = "Figure_" + speler.getDirection();
        }
        else{
            switch(bevat){
                case MUUR:
                    afbeeldingNaam = "Muur";
                    break;
                case BARRICADE:
                    afbeeldingNaam = "Barricade";
                    break;
                case SLEUTEL:
                    afbeeldingNaam = "Sleutel";
                    break;
                case EINDPUNT:
                    afbeeldingNaam = "Eindpunt";
                    break;                
                default:
                    afbeeldingNaam = "Barricade_Open";
                    this.afbeelding = new ImageIcon(workingDir + "\\projectImg\\" + "Barricade_Open.png");
                    break;
            }
        }
        this.afbeelding = new ImageIcon(workingDir + "\\projectImg\\" + afbeeldingNaam + ".png");
        return afbeelding;
    }

    public void setAfbeelding(ImageIcon afbeelding) {
        this.afbeelding = afbeelding;
    }

    public boolean isThereAPlayer(){
        return this.getSpeler() != null;
    }
    
    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }
    
}
