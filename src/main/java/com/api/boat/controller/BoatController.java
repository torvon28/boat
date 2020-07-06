package com.api.boat.controller;

import com.api.boat.Boat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
public class BoatController {

    @Operation(summary = "Control the boat", responses = {
            @ApiResponse(description = "Current position of the boat", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Boat.class))) })
    @GetMapping("/boat/{x}/{y}/{currentDirection}/{commands}")
    @ResponseBody
    public Boat getBoat(@Parameter(description = "Initial position of the boat on the x-axis") @PathVariable int x,
            @Parameter(description = "Initial position of the boat on the y-axis") @PathVariable int y,
            @Parameter(description = "Current direction that the boat is facing") @PathVariable String currentDirection,
            @Parameter(description = "Commands for controlling the boat") @PathVariable String commands) {
        Boat boat = new Boat(currentDirection, x, y);
        boat.navigate(commands);
        return boat;
    }
}