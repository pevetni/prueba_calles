package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class Semaphore extends TimerTask {
    private int id;
    private long changeTime;
    private Color color;
    private PropertyChangeSupport support;

    @Override
    public void run() {
        changeColor();
    }

    private void changeColor() {
        try {
            Semaphore oldSemaphore = Semaphore.builder()
                    .id(this.id)
                    .changeTime(this.changeTime)
                    .support(this.support)
                    .color(this.color)
                    .build();
            Color newColor = color.equals(Color.ROJO)?Color.VERDE:Color.ROJO;
            Semaphore nextSemaphore = Semaphore.builder()
                    .id(this.id)
                    .changeTime(this.changeTime)
                    .support(this.support)
                    .color(newColor)
                    .build();
            if(Objects.nonNull(this.support)) {
                this.support.firePropertyChange("semaphore", oldSemaphore, nextSemaphore);
            }
            Thread.sleep(this.changeTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
