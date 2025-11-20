package com.gamingroom.gameauth.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gamingroom.gameauth.representations.GameUserInfo;

public class GameUserDB {

    public static HashMap<Integer, GameUserInfo> gameUserInfos = new HashMap<>();
    static{
        gameUserInfos.put(1, new GameUserInfo(1, "Lokesh", "Gupta", "lokesh@example.com"));
        gameUserInfos.put(2, new GameUserInfo(2, "John", "Gruber", "john@example.com"));
        gameUserInfos.put(3, new GameUserInfo(3, "Melcum", "Marshal", "melcum@example.com"));
    }

    public static List<GameUserInfo> getGameUsers(){
        return new ArrayList<>(gameUserInfos.values());
    }

    public static GameUserInfo getGameUser(Integer id){
        return gameUserInfos.get(id);
    }

    public static void updateGameUser(Integer id, GameUserInfo gameUserInfo){
        gameUserInfos.put(id, gameUserInfo);
    }

    public static void removeGameUser(Integer id){
        gameUserInfos.remove(id);
    }
}
