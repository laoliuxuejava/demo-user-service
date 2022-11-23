## SpringCloud与SpringBoot的版本对应

### Spring Boot的版本以数字表示

例如：Spring Boot2.2.5.RELEASE ->主版本.次版本.增量版本（Bug修复）

### 版本号介绍：

```
·Alpha: 不建议使用，主要是以实现软件功能为主，通常只在软件开发者内部交流，Bug较多
·Beta：该版本相对a版已有很大的改进，消除了严重的错误，但还是存在着一些缺陷，需要经过多次测试来进一步消除；
·GA：General Availability，正式版本，官方推荐使用此版本，在国外都是用GA来说明release版本；
·M：又叫里程碑版本，表示该版本较之前版本有功能上的重大更新；
·PRE（不建议使用）：预版本，内部测试版本，主要是给开发人员和测试人员测试和找BUG用的；
·Release：最终版本，Release不会以单词形式出现在软件封面上，取而代之的是符号®；
·RC：该版本已经相当成熟了，基本上不存在导致错误的BUG，与即将发行的正式版相差无几；
·SNAPSHOT：快照版，可以稳定使用，且仍在继续改进的版本。
```

![image-20221122164430434](C:\Users\guser\Desktop\12月转正考核答辩材料\SpringCloud与SpringBoot的版本对应.assets\image-20221122164430434.png)

![image-20221122164508784](C:\Users\guser\Desktop\12月转正考核答辩材料\SpringCloud与SpringBoot的版本对应.assets\image-20221122164508784.png)

根据自己需要选择对应的springboot和springcloud的版本

|     SpringCloud版本     |                     SpringBoot版本                      |
| :---------------------: | :-----------------------------------------------------: |
|    2021.0.1-SNAPSHOT    |       Spring Boot >=2.6.4-SNAPSHOT and <2.7.0-M1        |
|        2021.0.0         |         Spring Boot >=2.6.1 and <2.6.4-SNAPSHOT         |
|      2021.0.0-RC1       |           Spring Boot >=2.6.0-RC1 and <2.6.1            |
|       2021.0.0-M3       |          Spring Boot >=2.6.0-M3 and <2.6.0-RC1          |
|       2021.0.0-M1       |          Spring Boot >=2.6.0-M1 and <2.6.0-M3           |
|        2020.0.5         |          Spring Boot >=2.4.0.M1 and <2.6.0-M1           |
|       Hoxton.SR12       |        Spring Boot >=2.2.0.RELEASE and <2.4.0.M1        |
|  Hoxton.BUILD-SNAPSHOT  |           Spring Boot >=2.2.0.BUILD-SNAPSHOT            |
|        Hoxton.M2        |          Spring Boot >=2.2.0.M4 and <=2.2.0.M5          |
| Greenwich.BUILD-SNAPSHO |    Spring Boot >=2.1.9.BUILD-SNAPSHOT and <2.2.0.M4     |
|      Greenwich.SR2      |  Spring Boot >=2.1.0.RELEASE and <2.1.9.BUILD-SNAPSHOT  |
|      Greenwich.M1       |        Spring Boot >=2.1.0.M3 and <2.1.0.RELEASE        |
| Finchley.BUILD-SNAPSHOT |   Spring Boot >=2.0.999.BUILD-SNAPSHOT and <2.1.0.M3    |
|      Finchley.SR4       | Spring Boot >=2.0.3.RELEASE and <2.0.999.BUILD-SNAPSHOT |
|      Finchley.RC2       |     Spring Boot >=2.0.2.RELEASE and <2.0.3.RELEASE      |
|      Finchley.RC1       |     Spring Boot >=2.0.1.RELEASE and <2.0.2.RELEASE      |
|       Finchley.M9       |     Spring Boot >=2.0.0.RELEASE and <=2.0.0.RELEASE     |
|       Finchley.M7       |         Spring Boot >=2.0.0.RC2 and <=2.0.0.RC2         |
|       Finchley.M6       |         Spring Boot >=2.0.0.RC1 and <=2.0.0.RC1         |
|       Finchley.M5       |          Spring Boot >=2.0.0.M7 and <=2.0.0.M7          |
|       Finchley.M4       |          Spring Boot >=2.0.0.M6 and <=2.0.0.M6          |
|       Finchley.M3       |          Spring Boot >=2.0.0.M5 and <=2.0.0.M5          |
|       Finchley.M2       |          Spring Boot >=2.0.0.M3 and <2.0.0.M5           |
|       Edgware.SR5       |                     1.5.20.RELEASE                      |
|       Edgware.SR5       |                     1.5.16.RELEASE                      |
|     Edgware.RELEASE     |                      1.5.9.RELEASE                      |
|       Dalston.RC1       |                      1.5.2.RELEASE                      |

