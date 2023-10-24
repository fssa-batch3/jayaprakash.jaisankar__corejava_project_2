package com.fssa.projectprovision.model;

public class Team {
    private int id;
    private String url; 
    private String team;
    private String roles;
    private int members;
    private String mail;

    public Team() {
       
    }

    public Team(String url, String team, String roles, int members,String mail) {
        this.url = url;
        this.team = team;
        this.roles = roles;
        this.members = members;
        this.mail= mail;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return roles;
    }
    
    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", url=" + url +
                ", team='" + team + '\'' +
                ", roles='" + roles + '\'' +
                ", members=" + members +
                '}';
    }
}
