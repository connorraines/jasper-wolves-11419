package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        // Create a RoadRunnerBotEntity
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
//                .setStartPose(new Pose2d(-60, 12, 0)) //Back Left Starting Position
                .setStartPose(new Pose2d(50, 12, 0)) // Initial position
                .build();

        // Define actions directly using runAction
        //myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(50, 12, 0)) // Initial position
        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-60, 12, 0))//Back Left Starting Position
                                .turn(1.6)
                                .strafeTo(new Vector2d(-12, 38))
                                .strafeTo(new Vector2d(-30, 10))
                                .turn(-2.6)
                                .build());

        RoadRunnerBotEntity myBot2 = new DefaultBotBuilder(meepMeep)
                //.setStartPose(new Pose2d(50, -12, 0)) // Initial position
                .setStartPose(new Pose2d(-60, -12, 0)) // Back Right Starting Position
                .build();


        //myBot2.runAction(myBot2.getDrive().actionBuilder(new Pose2d(50, -12, 0)) // Initial position
        myBot2.runAction(myBot2.getDrive().actionBuilder(new Pose2d(-60, -12, 0)) // Back Right Starting Position)
                                .turn(-1.6)
                                .strafeTo(new Vector2d(-12, -38))
                                .strafeTo(new Vector2d(-30, -10))
                                .turn(2.6)
                                .build());
        // Add the robot to the MeepMeep simulation
        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_OFFICIAL) // Correct field
                .addEntity(myBot) // Add the robot entity
                //.addEntity(myBot2)
                .start();
    }
}