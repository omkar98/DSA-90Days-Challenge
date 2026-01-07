package Neetcode.o3_Stack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CarFleet {
    static class CarDetails {
        int position;
        int speed;
        public CarDetails(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
        public int getPosition(){
            return this.position;
        }
        public int getSpeed(){
            return this.speed;
        }
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int totalCars = position.length;
        // group them and then sort based on position
        List<CarDetails> cars = IntStream.range(0, position.length)
                .mapToObj(i -> new CarDetails(position[i], speed[i]))
                .sorted(Comparator.comparingInt(CarDetails::getPosition).reversed())
                .collect(Collectors.toList());

        Deque<CarDetails> stk = new ArrayDeque<>();
        stk.push(cars.get(0));
        for(int i=1; i<totalCars; i++){
            CarDetails car1 = stk.peek();
            stk.push(cars.get(i));
            // Here this typecasting is imp. If not done, it failed almost all the testcases.
            double t1 = (double) (target - car1.getPosition()) /car1.getSpeed();
            double t2 = (double) (target - cars.get(i).getPosition()) /cars.get(i).getSpeed();
            if(t1>=t2) stk.pop();
        }
        System.out.println(stk.size());
        return stk.size();
    }
}
