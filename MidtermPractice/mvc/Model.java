package mvc;

import java.io.Serializable;

public class Model extends Publisher implements Serializable {
    private String fileName;
    private boolean unsavedChanges = false;

    public void changed(){
        unsavedChanges = true;
        notifySubscribers();
    }

    public String getFileName(){
        return fileName;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public boolean getUnsavedChanges(){
        return unsavedChanges;
    }
    public void setUnsavedChanges(boolean state){
        this.unsavedChanges = state;
    }
}
