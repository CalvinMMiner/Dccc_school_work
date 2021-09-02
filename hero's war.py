import random
system = 1
roll = 1
game = 1
main = 1
final = 0
alive = 1
kills  = 0
combat = 0
choice = 1
dif = 1
intro = 1
setup = 1
win = 0
lose = 0
gob  = 5
gobMagi = 7
hobGob = 10
troll = 30
oni = 25
shard = 1
giant = 45
dragon = 50
vampire = 35
colossus = 100
while system == 1:
    while setup == 1:
        combat = 1
        main = 1
        roll = 1
        kills  = 0
        alive = 1
        end=1
        print("Your hero stands at the cusp of a foul dungon.")
        print("he enters without hesitation, will he survive to exit?")
        setup = 0
        while roll== 1:
            Maxhealth = random.randint(30,50)
            health = Maxhealth
            damage = random.randint(5,10)
            heal = random.randint(6,9)
            print("max health:", health)
            print("damage:", damage)
            print("heal:", heal)
            roll=int(input("do you  wish to re-roll  your stats? [1/0] "))
        while dif == 1:
            difficulty = int(input("do you wish to change the difficulty? [1/0] "))
            if difficulty == 1:
                MaxMonsters = int(input("how many foe's do you wish to face?: "))
                monsters = MaxMonsters
                dif = 0
            else:
                MaxMonsters = 100
                monsters = MaxMonsters
                dif = 0
                 
    while game == 1:
        combat = 1
        main = 1
        if(monsters>=3/4*MaxMonsters):
            foe=(gob,gob,gob,gob,gob,gobMagi,gobMagi,gobMagi,hobGob,hobGob,troll)
        elif(monsters>=1/2*MaxMonsters):
             foe=(gob,gobMagi,gobMagi,hobGob,hobGob,hobGob,hobGob,troll,troll,oni,shard,giant)
        elif(monsters>=1/4*MaxMonsters):
            foe=(hobGob,troll,troll,troll,hobGob,oni,oni,shard,shard,giant,giant,vampire)
        elif(monsters>=1/10*MaxMonsters):
            foe=(troll,oni,oni,oni,shard,shard,shard,giant,giant,giant,dragon,vampire)
        elif(monsters>0):
            foe=(shard,vampire,vampire,vampire,dragon,dragon,colossus)
        foeHealth=(random.choice(foe))
        if foeHealth==5:        
            foeDamage = random.randrange(3)+1
            foeName = ["a standard goblin approaches","with a gleaful houl a goblin attacks","as the hero proceeds he trips on a sleeping goblin"]
        elif foeHealth==10:  
            foeDamage = random.randrange(5)+1
            foeName = ["a hobgoblin charges the hero","a hobgoblin ambushes the hero","the hero walks into a sleep walking hobGoblin"]
        elif foeHealth==7: 
            foeDamage = random.randrange(15) + 1
            foeName = ["a goblin mage approaches","a goblen mage sends a fire ball whistling past your ear","the hero stumbels opon a lone goblin mage"]
        elif foeHealth==30: 
            foeDamage = random.randrange(7) +1
            foeName = ["with an unholy bellow a troll charges at you","a unbearable stench assults the hero"]
        elif foeHealth==25: 
            foeDamage = random.randint(11,13)
            foeName = ["metal armor screaches as a oni leapes into the fight","a brutal warcry anounces the arival of a oni"] 
        elif foeHealth==1: 
            foeDamage = random.randint(23,30)
            foeName = ["a soft crinkling signals the approach of a shard","a shard cassualy approaches","the air fractures apart showing the soft form of a shard"]
        elif foeHealth==45: 
            foeDamage = random.randint(6,10)
            foeName = ["the earth shakes as a giant lumbers towards you","the hero accidentaly disturbs the slumber of a giant"]
        elif foeHealth==35:
            foeDamage = random.randint(17,20)
            foeName = ["a vicious hiss reveals the presence of a vampire","crual laughing warns you of a approaching vamire","a vampire comes stalking out of the shadows"]
        elif foeHealth==50:
            foeDamage = random.randint(15,18)
            foeName = ["with a terable roar a dragon lands","the room becomes superheated as a enraged drogon rises from it's slumber","a dragon stands waiting for the hero"]
        elif foeHealth==100:
            foeDamage = random.randrange(30) + 1
            foeName = ["the grounds quakes an shudders as a colossus nears","as the hero walks the ground beneath him shudders and rises, revealing a 20 meter tall colossus"]
                    
        entrance = 1
        while alive == 1 and main == 1 and combat == 1:
            print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
            print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
            if entrance==1:
                print(random.choice(foeName))
                entrance=0
            print("monsters remaining:",monsters)
            print("health remaining: ",health,"/",Maxhealth)
            choice = int(input("will you heal(0), attack(1) or defend(2): "))

            if choice == 1:
                health = health-foeDamage
                foeHealth = foeHealth-damage
            elif choice == 2:
                health = health+2
                foeHealth = foeHealth
            else: 
                health = health+heal
                health = health-(foeDamage/2)

            if health>Maxhealth:
                health = Maxhealth
            if foeHealth<=0:
                main=0
                monsters = monsters - 1
                kills=kills+1
                
            if monsters<=0:
                main = 0
                final = 1
            elif health<=0:
                main = 0
                end = 2
        intro = 1
        while alive == 1 and final == 1:
            if intro == 1:
                foeHealth = 666
                foeDamage = random.randint(15,20)
                special = 666
                print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
                print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
                print("after a long and grualing fight the last monster falls")
                print("the hero starts to relax at long last")
                print("however a thunderus  stomp shakes the  ground")
                print("it sounds again and again geting closer and closer")
                print("then its humongus form reveals its self, the demon king")
                print("the hero rises, his armaments shining with holy power, ready for his final battle")
                input(print("press any key to begin the final battle"))
                damage = damage*5
                heal = heal*2
                intro = 0
            attack = random.randrange(4)
            print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
            print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
            print("demon king health remaining: ",foeHealth,"/ 666")
            if attack ==0:
                print("the demon king is preparing a special attack, dont let him hit you!")
            print("health remaining: ",health,"/",Maxhealth)
            choice = int(input("will you heal(0), attack(1) or defend(2): "))

            if choice!= 2 and attack == 0:
                health = health - special
            elif choice == 1:
                health = health-foeDamage
                foeHealth = foeHealth-damage
            elif choice == 2:
                health = health+2
            else: 
                health = health+heal
                health = health-(foeDamage/2)

            if health>Maxhealth:
                health = Maxhealth
            if foeHealth<=0:
                final =0
                end = 2
                win = 1
            elif health<=0:
                alive = 0
                end = 2
                lose = 1
                
        while end == 2:
           print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
           print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
           if monsters<=0 and win == 1:
                result = ["bloodied and tired your hero emerges victorious","the days were long but at long last the hero returns alive and victorious","you win"]    
           elif health<=0:
                result =  ["your hero fought long and hard, but in the end he dies regardless","your hero falls his last stand ending badly","you lose"]
           if win == 1:
               print("with a earth shattering boom the foul demon king falls")
               print(random.choice(result))
               print("final stats")
               print("monsters killed:", kills, ", demon king slain")
               print("monsters remaining:", monsters)
               print("health remaining", health)
            
           elif lose ==1:
               print("with a soul shatering laugh  the demon king stand atop the hero's shattered boddy")
               print(random.choice(result))
               print("final stats")
               print("monsters killed:", kills, "demon king alive")
               print("monsters remaining:", monsters)
               print("health remaining", health)
           else: 
               print(random.choice(result))
               print("final stats")
               print("monsters killed:", kills)
               print("monsters remaining:", monsters)
               print("health remaining", health)
           end = 0
           system =1
           game = 0
           setup = 0
           input("\n\npress any key to exit")


