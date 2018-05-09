/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFTPStorage;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author TuanNguyen
 */
public class Data implements Serializable {

    private boolean pauseUpload;
    private boolean resumeUpload;
    private boolean stopUpload;
    private byte[] file;
    private String name;

    public boolean isPauseUpload() {
        return pauseUpload;
    }

    public void setPauseUpload(boolean pauseUpload) {
        this.pauseUpload = pauseUpload;
    }

    public boolean isResumeUpload() {
        return resumeUpload;
    }

    public void setResumeUpload(boolean resumeUpload) {
        this.resumeUpload = resumeUpload;
    }

    public boolean isStopUpload() {
        return stopUpload;
    }

    public void setStopUpload(boolean stopUpload) {
        this.stopUpload = stopUpload;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    
}
