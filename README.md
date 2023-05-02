# ProgMod

## Model versions
| Version   | Description
|:---------:|:-------------------------------------|
|v. 1.0     |First system boundary definition model|
|v. 1.0b    |Refined system boundary definition model. Adds preconditions for step function.  |
|v. 1.1     |Separated controller and environment. |
|v. 1.2     |Implemented controller logic functionality. |
|v. 1.3     |Completely separated controller and environment by deploying the classes on different CPUs. No more direct access to variables. |
|v. 1.4     |Moving from 'user-centric' to 'controller-centric' design. We now have real-time operation calls. |
|v. 2.0     | Fully distributed system with sensor+actuator interfaces between controller and environment. |
|v. 2.1a     | First iteration of implementing controller modes. Modes *Initialization* and *Operating* implemented. |
|v. 2.1b     | Second iteration of implementing controller modes. Modes  *Initialization*, *Operating*, and *Stable* implemented. |
|v. 2.1c     | Third iteration of implementing controller modes. Modes  *Initialization*, *Operating*, *Stable*, *Shutdown*, and *Emergency* implemented. |
|v. 2.2      |Implemented environment events: *SensorFail, MotorFail,* and *RepositionArm* as well as controller events: *AlterTargetAngle* and *ShutdownController*.     | 
|v. 3.0      |Introducing the controller’s proportional and derivative (PD) components, including gravity compensation.| 