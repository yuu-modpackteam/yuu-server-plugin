package yuu.event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import yuu.Season

class SeasonChangeEvent(val from: Season, val to: Season) : Event() {
    private val handlerList = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlerList
    }
}