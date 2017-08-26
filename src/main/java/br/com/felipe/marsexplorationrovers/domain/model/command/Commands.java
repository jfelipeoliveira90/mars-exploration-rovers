package br.com.felipe.marsexplorationrovers.domain.model.command;

import br.com.felipe.marsexplorationrovers.domain.model.command.impl.LeftCommand;
import br.com.felipe.marsexplorationrovers.domain.model.command.impl.MoveCommand;
import br.com.felipe.marsexplorationrovers.domain.model.command.impl.RightCommand;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static br.com.felipe.marsexplorationrovers.domain.model.command.Command.LEFT;
import static br.com.felipe.marsexplorationrovers.domain.model.command.Command.MOVE;
import static br.com.felipe.marsexplorationrovers.domain.model.command.Command.RIGHT;

public final class Commands {
    private static final Map<String, Command> commandMap;

    static {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(LEFT, new LeftCommand())
                .put(RIGHT, new RightCommand())
                .put(MOVE, new MoveCommand())
                .build();
    }

    public static Map<String, Command> getCommandMap() {
        return commandMap;
    }
}
