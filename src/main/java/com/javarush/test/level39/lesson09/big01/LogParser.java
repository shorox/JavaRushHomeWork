package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery{
    private Path logDir;
    private static final String DATETIME_PATTERN = "dd.MM.yyyy HH:mm:ss";

    public LogParser(Path logDir){
        this.logDir = logDir;
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat(DATETIME_PATTERN, Locale.ENGLISH);
    }

    private List<LogDataRow> parseLogs() {
        return parseLog(logDir, dateFormat());
    }

    private List<LogDataRow> parseLog(Path logDir, SimpleDateFormat dateFormat){
        List<LogDataRow> dataRows = new ArrayList<>();
        File[] listFiles = new File(logDir.toString()).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".log");
            }
        });
        for(File file : listFiles){
            try(BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
                while(r.ready())
                    dataRows.add(parseLogLineParts(r.readLine().split("\t"), dateFormat));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return dataRows;
    }

    private LogDataRow parseLogLineParts(String[] logLineParts, SimpleDateFormat dateFormat) throws Exception{
        LogDataRow dataRow = new LogDataRow();
        dataRow.ip = logLineParts[0];
        dataRow.user = logLineParts[1];
        dataRow.date = dateFormat.parse(logLineParts[2]);
        String[] sEvent = logLineParts[3].split(" ");
        dataRow.event = Event.valueOf(sEvent[0]);
        if (dataRow.event == Event.SOLVE_TASK || dataRow.event == Event.DONE_TASK)
            dataRow.task = Integer.parseInt(sEvent[1]);
        else
            dataRow.task = -1;
        dataRow.status = Status.valueOf(logLineParts[4]);
        return dataRow;
    }

    private boolean belongToPeriod(Date target, Date after, Date before) {
        if (after != null && before != null) {
            return after.getTime() <= target.getTime() && before.getTime() >= target.getTime();
        } else if (after == null && before != null) {
            return before.getTime() >= target.getTime();
        } else if (before == null && after != null) {
            return after.getTime() <= target.getTime();
        } else {
            return true;
        }
    }

    //---------------------------- 1

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before)) set.add(p.ip);
        return set;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.user.equals(user)) set.add(p.ip);
        return set;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == event) set.add(p.ip);
        return set;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.status == status) set.add(p.ip);
        return set;
    }

    //---------------------------- 2

    @Override
    public Set<String> getAllUsers() {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            set.add(p.user);
        return set;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before)) set.add(p.user);
        return set.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        int count = 0;
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.user.equals(user)) count++;
        return count;
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.ip.equals(ip)) set.add(p.user);
        return set;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.LOGIN) set.add(p.user);
        return set;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.DOWNLOAD_PLUGIN) set.add(p.user);
        return set;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.WRITE_MESSAGE) set.add(p.user);
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.SOLVE_TASK) set.add(p.user);
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.SOLVE_TASK && p.task == task) set.add(p.user);
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.DONE_TASK) set.add(p.user);
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.DONE_TASK && p.task == task) set.add(p.user);
        return set;
    }

    //---------------------------- 3

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.user.equals(user) && p.event == event) set.add(p.date);
        return set;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.status == Status.FAILED) set.add(p.date);
        return set;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.status == Status.ERROR) set.add(p.date);
        return set;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        List<LogDataRow> dataRows = parseLogs();
        Date d = new Date(Long.MAX_VALUE);
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.user.equals(user) && p.event == Event.LOGIN && (p.date.getTime() < d.getTime())) d = p.date;
        return d.getTime() != Long.MAX_VALUE ? d : null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<LogDataRow> dataRows = parseLogs();
        Date d = new Date(Long.MAX_VALUE);
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.user.equals(user) && p.event == Event.SOLVE_TASK && p.task == task && (p.date.getTime() < d.getTime())) d = p.date;
        return d.getTime() != Long.MAX_VALUE ? d : null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<LogDataRow> dataRows = parseLogs();
        Date d = new Date(Long.MAX_VALUE);
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.user.equals(user) && p.event == Event.DONE_TASK && p.task == task && (p.date.getTime() < d.getTime())) d = p.date;
        return d.getTime() != Long.MAX_VALUE ? d : null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.user.equals(user) && p.event == Event.WRITE_MESSAGE)
                set.add(p.date);
        return set;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.user.equals(user) && p.event == Event.DOWNLOAD_PLUGIN) set.add(p.date);
        return set;
    }

    //---------------------------- 4

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before)) set.add(p.event);
        return set;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.ip.equals(ip)) set.add(p.event);
        return set;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.user.equals(user)) set.add(p.event);
        return set;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.status == Status.FAILED) set.add(p.event);
        return set;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.status == Status.ERROR) set.add(p.event);
        return set;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        List<LogDataRow> dataRows = parseLogs();
        int count = 0;
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.SOLVE_TASK && p.task == task) count++;
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        List<LogDataRow> dataRows = parseLogs();
        int count = 0;
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.DONE_TASK && p.task == task) count++;
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.SOLVE_TASK && !map.containsKey(p.task))
                map.put(p.task, getNumberOfAttemptToSolveTask(p.task, after, before));
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        List<LogDataRow> dataRows = parseLogs();
        for(LogDataRow p : dataRows)
            if(belongToPeriod(p.date, after, before) && p.event == Event.DONE_TASK && !map.containsKey(p.task))
                map.put(p.task, getNumberOfSuccessfulAttemptToSolveTask(p.task, after, before));
        return map;
    }

    //---------------------------- 5, 6, 7

    @Override
    public Set<Object> execute(String query) {
        List<LogDataRow> dataRows = parseLogs();
        Pattern queryPattern = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.*?)\")?"
                + "( and date between \"(.*?)\" and \"(.*?)\")?");

        Matcher matcher = queryPattern.matcher(query);
        matcher.find();

        String field1 = matcher.group(1);
        String field2  = matcher.group(3);
        String value1 = matcher.group(4);

        Set<Object> result = new HashSet<>();
        try
        {
            Date value2 = null;
            Date value3 = null;
            if(matcher.group(5) != null)
            {
                value2 = dateFormat().parse(matcher.group(6));
                value3 = dateFormat().parse(matcher.group(7));
            }

            for (LogDataRow dataRow : dataRows)
                if (filterLogRowByAttr(dataRow, field2, value1) && this.belongToPeriod(dataRow.date, value2, value3))
                    result.add(getLogDataRowAttr(field1, dataRow));
        }
        catch (ParseException ignore) {
        }
        return result;
    }

    private Object getLogDataRowAttr(String field, LogDataRow dataRow){
        switch (field)
        {
            case "ip":
                return dataRow.ip;
            case "user":
                return dataRow.user;
            case "date":
                return dataRow.date;
            case "event":
                return dataRow.event;
            case "status":
                return dataRow.status;
            default:
                return null;
        }
    }

    private boolean filterLogRowByAttr(LogDataRow dataRow, String filter, String value) throws ParseException
    {
        switch (filter)
        {
            case "ip":
                return dataRow.ip.equals(value);
            case "user":
                return dataRow.user.equals(value);
            case "date":
                return dataRow.date.equals(value == null ? null : dateFormat().parse(value));
            case "event":
                return dataRow.event.equals(value == null ? null : Event.valueOf(value));
            case "status":
                return dataRow.status.equals(value == null ? null : Status.valueOf(value));
            default:
                return false;
        }
    }

    private static class LogDataRow{
        String ip;
        String user;
        Date date;
        Event event;
        int task;
        Status status;
    }
}