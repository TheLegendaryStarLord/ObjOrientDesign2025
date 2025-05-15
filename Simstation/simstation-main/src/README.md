# SimStation - README

## Authors – Team Members (Group 8)
- **Lwin Moe**
- **Adam Sanchez**
- **Vinzent Schubert**

## Team Leader
- **Vinzent Schubert**

## Class
- **CS 151 Object Oriented Design @ SJSU**

## Created Date
- **Apr 1, 2025**

## Last Modified Date
- **Apr 16, 2025**

---

## Overview

**SimStation** is a Java-based multi-agent simulation framework built using the **Model-View-Controller (MVC)** architecture. It allows developers to model agent-based systems such as epidemics, flocking behavior, or economic games through interactions between mobile agents in a dynamic world.

SimStation supports simulation control (start, stop, pause, resume), visualization, and agent-specific behaviors. Developers can extend it to create their own simulations using only a few custom classes.

---

## Included Simulations

### 1. Plague
Simulates the spread of a virus among a population of agents.

- Red: Infected agents
- Blue: Susceptible agents
- Green: Recovered agents
- White: Dead agents

### 2. Greed
Models cows grazing patches of grass in a meadow

- Red: Hungry cows
- Green background: Grass patch (intensity = energy level)
- White: Dead cows

### 3. Random Walk
Simple simulation of agents (drunks) moving in random directions with random step sizes.

- Tests smooth motion, rendering, and basic interaction.

### 4. Prisoner's Dilemma Tournament

- Agents have one of four strategies:
    - Always Cooperate
    - Always Cheat
    - Random
    - Tit-for-Tat
- Fitness is updated based on results of each game.

---

## Technical Design

### Architecture
- SimStation is a framework **on top of the MVC framework**.
- Each simulation defines:
    - A custom `World` (environment)
    - A custom `Agent` (with an `update()` behavior)
    - Optional custom `View` and `Panel` for GUI sliders

### Agent Behavior
- Each agent is a **thread** (concurrent behavior)
- Agents move, interact with neighbors, and make decisions
- Movement wraps around the world’s edges

### World
- Manages all agents
- Can fetch nearby neighbors using `getNeighbor(...)`
- Maintains simulation time (clock)

