package frc.robot;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkFlex;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;
public class shooter {
     public double acceleration=.1;
     public SparkFlex myMotor1 = new SparkFlex(1, MotorType.kBrushless);
     public SparkFlex myMotor2 = new SparkFlex(2, MotorType.kBrushless);
     @SuppressWarnings("removal")
   public void update()
     {
     SparkFlexConfig config = new SparkFlexConfig();
     config.openLoopRampRate(acceleration); 
     config.closedLoopRampRate(acceleration);
     myMotor1.configure(config,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
     myMotor2.configure(config,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
     }
     public void increase()
     {
        if(acceleration<1)
        {
        acceleration+=.01;
        update();
        }
     }
     public void decrease()
     {
        if(acceleration>0)
        {
        acceleration-=.01;
        update();
        }
     }
     public void pickup(double speed)
     {
      myMotor2.set(speed);
     }
    public void shoot(double power)
    {
        myMotor1.set(power);
    }
}
