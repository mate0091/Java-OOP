import java.awt.Color;
 /**
 * Represents a car.
 * The attributes are speed, engine power and color.
 * The methods are accelerate,
 * decelerate, getSpeed, getColor, getPower,
 * getAcceleration, and getMaxSpeed.
 *
 * @author Laboratory Team
 */
 public class Car
 {
     private String brandName;
     private int speed = 0; // current car speed
     private Color color;
     private int power;
     private int accelerationStep=0; // speed increase when gas pedal pushed
     private int maxSpeed; // maximum speed for this car

     private static final int MIN_SPEED = 0; // minimum speed for all cars; km/h
     private static final int MAX_SPEED = 300; // speed limit on all cars; km/h
     private static final int MIN_POWER = 4; // minimum power for all cars; no less than 4 bhp
     private static final int MAX_POWER = 500; // maximum power for all cars.no more than 500 bhp
     private static final int ACCELERATION_MIN_STEP = 1; // minimum speed increaseper second when gas pedal pushed
     private static final int ACCELERATION_MAX_STEP = 30; // maximum speed increase per second
                                                          // when gas pedal pushed
     private FuelTank fuel;
     /**
     * Constructor to create a new Car object
     * @param brand name or manufacturer.
     * @param color color of the Car object - one of Java color constants
     * @param power engine power
     * @param accelerationStep increase in speed when gas pedal pushed
     */
     public Car(String brand, Color color, int power, int maxSpeed, int accelerationStep)
     {
         //creates a new Car object with specified brand name, color, engine power, and maximum speed
         this.fuel = new FuelTank(100f, 0f);
         this.brandName = brand;
         this.color = color;
         this.power = (power > 4)? power: 4;
         if (maxSpeed < 0) this.maxSpeed = MIN_SPEED; // this car wil never move
         else
         if (maxSpeed < MAX_SPEED) this.maxSpeed = maxSpeed;
         else maxSpeed = MAX_SPEED;
         if (power < MIN_POWER) this.power = MIN_POWER;
         else
         if (power > MAX_POWER) this.power=MAX_POWER;
         if (accelerationStep < ACCELERATION_MIN_STEP)
         this.accelerationStep = ACCELERATION_MIN_STEP;
         else
         if (accelerationStep > ACCELERATION_MAX_STEP)
         this.accelerationStep = ACCELERATION_MIN_STEP;
         else
         this.accelerationStep = accelerationStep;
         
         
     }
     /**
     * Simulates pressing the accelerator.
     * @return the new speed
     */
     public int accelerate()
     {
         int newSpeed = speed + getAcceleration();
         
         if(newSpeed <= getMaxSpeed())
         {
             speed = newSpeed;
         }
         else
         {
             speed = getMaxSpeed();
         }
         
         fuel.releaseFuel(speed * 0.1f);
         
         return speed;
     }
     /**
     * Simulates releasing the accelerator.
     * M. Joldoş Laboratory Guide 4. Flow Control and Simple Classes
     * T.U. Cluj-Napoca Object Oriented Programming 7
     * @return the new speed
     */
     public int decelerate()
     {
         if(speed > MIN_SPEED)
         {
             speed--;
         }
         
         fuel.releaseFuel(speed * 0.1f);
         
         return speed;
     }
     /**
     * @return the current speed
     */
     public int getSpeed()
     {
         return speed;
     }
     /**
     * @return the max speed
     */
     public int getMaxSpeed()
     {
         return MAX_SPEED;
     }
     /**
     * @return the color of the car
     */
     public Color getColor()
     {
         return color;
     }
     /**
     * @return the brand name of the car
     */
     public String getBrandName()
     {
         return brandName;
     }
     /**
     * @return the car's acceleration step
     */
     public int getAcceleration()
     {
         return accelerationStep;
     }
     /**
     * @return the power of the car
     */
     public int getPower()
     {
         return power;
     }
     
     public float getFuelLevel()
     {
         return fuel.getLevel();
     }
     
     public float getCapacity()
     {
         return fuel.getCapacity();
     }
 }