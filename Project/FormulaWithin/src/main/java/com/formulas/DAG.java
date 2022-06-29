package com.formulas;

import java.util.ArrayList;

class Graphs {
	ArrayList<Nodes> allNodes;

    Graphs(){
        allNodes = new ArrayList<>();
    }

    public void addNode(Nodes a){
        allNodes.add(a);
    }

    public Nodes getNode(int i){
        return allNodes.get(i);
    }
}

class Nodes{
    String data;
    ArrayList<Nodes> child;

    Nodes(String data){
        this.data = data;
        child = new ArrayList<Nodes>();
    }
}
