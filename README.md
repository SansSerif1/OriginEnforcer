# OriginEnforcer
A mod that assigns Origins to players from a config file, disabling the choosing screen.

## How to use
- Download the mod and move it to the mods/ folder in your fabric SERVER directory.
- Start the server to generate config file
- Shutdown the server
- go to config/originenforcer.properties
- Add player origins per line, for example: Notch=origins:shulk
- Profit

(Now the first time Notch joins, the server kicks him (and does the "/origins set Notch origins:origin origins:shulk" command for you). The second time he joins, no origin choosing screen is going to appear and he will play as Shulk. Simple as that)

## Download
Go to [releases](https://github.com/SansSerif1/OriginEnforcer/releases) and download the latest jar file.

## Custom kick message
The message when someone gets kicked defaults to some generic kick message that tells Notch to join back. To change this message, add dmsg=YOURMSG to the config file to change the kick message.

## Why would you do this?
Well I made a discord bot that assignes random origin to everyone on the server, with the option to reroll once. (To make sure that everyone wont choose phantom) I made it so it saves these origins to the config file of the mod, so they wont have an option to choose the most OP origin, but the one the bot assigned to them.
