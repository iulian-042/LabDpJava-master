package Package1;

import java.util.concurrent.TimeUnit;

public class Image implements Element {
    private String _imageName;

    public String get_imageName() {
        return _imageName;
    }

    public void set_imageName(String _imageName) {
        this._imageName = _imageName;
    }

    public Image(String imageName){
        _imageName = imageName;

        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    @Override
    public void print() {
        System.out.println("Image name: "+get_imageName());
    }
}
