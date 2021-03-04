package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Driver implements PropertyChangeListener {
    private int id;
    private Car car;
    private int destinationStreetId;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Semaphore semaphore = (Semaphore) evt.getNewValue();
        if(car.getStreet().getSemaphoreId()==semaphore.getId() && Color.VERDE.name().equals(semaphore.getColor().name())) {
            int newStreet = this.car.getStreet().getId()+1;
            int nextStreet = newStreet < destinationStreetId ? newStreet+1:destinationStreetId;
            int newSemaphore = this.getCar().getStreet().getSemaphoreId()<destinationStreetId?this.getCar().getStreet().getSemaphoreId()+1:destinationStreetId;
            System.out.println(String.format("El automovil %s cruza desde la calle %s a la calle %s que tiene el semaforo %s", this.car.getId(), this.car.getStreet().getId(), newStreet, newSemaphore));
            this.car.setStreet(Street.builder()
                    .id(newStreet)
                    .semaphoreId(newSemaphore)
                    .nextStreet(nextStreet)
                    .build());
            if(destinationStreetId==this.car.getStreet().getId()) {
                System.out.println("LLego a su destino...");
                System.exit(0);
            }
        }
    }
}
