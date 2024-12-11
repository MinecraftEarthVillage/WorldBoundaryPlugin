# 灵感来源于WorldBorder
https://github.com/PryPurity/WorldBorder
WorldBorder的越界传送只是简单的把人丢到对边（例如10752→-10752，直接南北极互通是吧）
可惜搞砸了

# 预期目标

通过配置文件提供数据定义一片矩形范围，当玩家达到或越过限定数值（在config指定）后，将玩家当前XZ坐标乘上指定倍数，使得玩家被传送一次，为了防止玩家被传送后仍处于触发条件造成一直传送下去，因此在正式传送前需要个额外处理，来将玩家当前越界的坐标回退一格，防止玩家传送一次后还会再触发传一次
假如changeZ指定为1，changeX指定为-1，Z坐标限制设为-10和10，为那么玩家在“Z坐标到达或超过10”、“到达或小于-10”时候将当前玩家X坐标乘上-1，Z坐标因为乘上的1，所以传送后不变（玩家会一直处在Z触发点），所以Z坐标会先减去1再乘上1，玩家就被传送到另一地点。
这在模拟“地球是圆的”类似场景很有用