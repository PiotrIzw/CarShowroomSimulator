package carshowroomsimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarShowroomContainer {

    private final Map<String, CarShowroom> showroomMap;

    public CarShowroomContainer(Map<String, CarShowroom> showroomMap) {
        this.showroomMap = showroomMap;
    }

    public CarShowroom addCenter(String showroomName, int showroomCapacity) {
        CarShowroom showroom = new CarShowroom(showroomName, new ArrayList<>(), showroomCapacity);
        showroomMap.put(showroomName, showroom);
        return showroom;
    }

    public void removeCenter(String showroomName) {
        showroomMap.remove(showroomName);
    }

    public List<CarShowroom> findEmpty() {
        List<CarShowroom> emptyCarsList = new ArrayList<>();
        for (Map.Entry<String, CarShowroom> entry : showroomMap.entrySet()) {
            if (entry.getValue().getCarList().size() == 0) {
                emptyCarsList.add(entry.getValue());
            }
        }
        return emptyCarsList;
    }

    public void summary() {
        for (Map.Entry<String, CarShowroom> entry : showroomMap.entrySet()) {
            double showroomCapacity = entry.getValue().getMaxShowroomCapacity();
            double showroomFilling = entry.getValue().getCarList().size();
            String showroomName = entry.getValue().getShowroomName();
            double percentageFilling = (showroomFilling / showroomCapacity) * 100;
            System.out.println("Showroom Name: " + showroomName + ", Percentage Filling: " + percentageFilling + "%");

        }
    }
}
