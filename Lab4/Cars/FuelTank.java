public class FuelTank
{
    // instance variables - replace the example below with your own
    private float capacity;
    private float level;
    
    private static final float CAPACITY_MIN = 4f;
    private static final float CAPACITY_MAX = 200f;
    private static final float LEVEL_MIN = 0f;
    private static final float LEVEL_MAX = 1f;
    private static final float DEFAULT_CAPACITY = 60f;
    
    /**
     * Constructor for objects of class FuelTank
     */
    public FuelTank()
    {
        capacity = DEFAULT_CAPACITY;
        level = LEVEL_MAX;
    }
    
    public FuelTank(float cap, float level)
    {
        this.capacity = cap;
        this.level = level;
    }

    public float fill(float amount)
    {
        float c = capacity * level;
        
        if(c + amount > capacity)
        {
            level = LEVEL_MAX;
        }
        
        else
        {
            level += amount / capacity;
        }
        
        return level;
    }
    
    public boolean releaseFuel(float amount)
    {
        float c = capacity * level;
        
        if(amount > c) 
        {
            level = LEVEL_MIN;
            return false;
        }
        
        else
        {
            level -= amount / capacity;
        }
        return true;
    }
    
    public float getLevel()
    {
        return this.level;
    }
    
    public float getCapacity()
    {
        return this.capacity;
    }
}
