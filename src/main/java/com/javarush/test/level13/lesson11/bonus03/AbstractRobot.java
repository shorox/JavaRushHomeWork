package com.javarush.test.level13.lesson11.bonus03;

public abstract class AbstractRobot
{
    private static int hitCount;

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public BodyPart attack()
    {
        BodyPart attackedBodyPart = null;
        hitCount++;

        if (hitCount == 1)
            attackedBodyPart =  BodyPart.ARM;
        else if (hitCount == 2)
            attackedBodyPart =  BodyPart.HEAD;
        else if (hitCount == 3)
            attackedBodyPart =  BodyPart.LEG;
        else if (hitCount == 4)
            attackedBodyPart = BodyPart.BREAST;
        else if (hitCount == 5)
        {
            hitCount = 0;
            attackedBodyPart = BodyPart.ARM;
        }
        return attackedBodyPart;
    }

    public BodyPart defense()
    {
        BodyPart defencedBodyPart = null;
        hitCount++;

        if (hitCount == 1)
            defencedBodyPart =  BodyPart.HEAD;
        else if (hitCount == 2)
            defencedBodyPart =  BodyPart.LEG;
        else if (hitCount == 3)
            defencedBodyPart =  BodyPart.ARM;
        else if (hitCount == 4)
            defencedBodyPart =  BodyPart.LEG;
        else if (hitCount == 5)
        {
            hitCount = 0;
            defencedBodyPart =  BodyPart.BREAST;
        }
        return defencedBodyPart;
    }
}
