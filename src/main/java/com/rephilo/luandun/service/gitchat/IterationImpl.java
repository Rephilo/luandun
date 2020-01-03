package com.rephilo.luandun.service.gitchat;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * gitchat 迭代法
 *
 * @author rephilo
 */
@Service
public class IterationImpl {
    /**
     * 总工作站数量
     */
    private static final Integer STATIONS = 100;
    /**
     * 总流水线数量
     */
    private static final Integer LINES = 3;

    /**
     * 装配线与工作站问题
     *
     * @param result
     * @param param
     * @param line    当前进入的流水线
     * @param station 当前的工作站
     */
    public static void searchStationsSequence(WorkTimeResult result, WorkTime param, int line, int station) {
        //1.当前为最后一次装配，完成结果，退出递归
        if (station == STATIONS - 1) {
            result.setFs(result.getFs() + param.getAssembleTime()[line][station]);
            result.setFs(result.getFs() + param.getExitTime()[line]);
            result.getLine()[station] = line;
            if (result.getFs() < result.getFfs()) {
                result.setFfs(result.getFs());
            }

            return;
        }

        //2.记录中间结果到line
        int curCost = result.getFs() + param.getAssembleTime()[line][station];
        result.getLine()[station] = line;

        //3.调整line和station参数，完成递归
        result.setFs(curCost);
        searchStationsSequence(result, param, line, station + 1);

        //选择另一条装配线的下一个装配站，需要计算转移开销
        result.setFs(curCost);
        result.setFs(result.getFs() + param.getTransportTime()[line][station + 1]);
        int nextList = (line + 1) % LINES;
        searchStationsSequence(result, param, nextList, station + 1);
    }

    private static class WorkTime {
        /**
         * 组装时间
         */
        Integer[][] assembleTime;
        /**
         * 转移时间
         */
        Integer[][] transportTime;
        /**
         * 进入时间
         */
        Integer[] enterTime;
        /**
         * 退出时间
         */
        Integer[] exitTime;

        public Integer[][] getAssembleTime() {
            return assembleTime;
        }

        public void setAssembleTime(Integer[][] assembleTime) {
            this.assembleTime = assembleTime;
        }

        public Integer[][] getTransportTime() {
            return transportTime;
        }

        public void setTransportTime(Integer[][] transportTime) {
            this.transportTime = transportTime;
        }

        public Integer[] getEnterTime() {
            return enterTime;
        }

        public void setEnterTime(Integer[] enterTime) {
            this.enterTime = enterTime;
        }

        public Integer[] getExitTime() {
            return exitTime;
        }

        public void setExitTime(Integer[] exitTime) {
            this.exitTime = exitTime;
        }
    }

    private static class WorkTimeResult {
        /**
         * 遍历过程中的当前结果记录
         */
        private Integer[] line;
        private Integer fs;
        /**
         * 当前已知的最优结果
         */
        private Integer[] fline;
        private Integer ffs;

        public Integer[] getLine() {
            return line;
        }

        public void setLine(Integer[] line) {
            this.line = line;
        }

        public Integer getFs() {
            return fs;
        }

        public void setFs(Integer fs) {
            this.fs = fs;
        }

        public Integer[] getFline() {
            return fline;
        }

        public void setFline(Integer[] fline) {
            this.fline = fline;
        }

        public Integer getFfs() {
            return ffs;
        }

        public void setFfs(Integer ffs) {
            this.ffs = ffs;
        }
    }


    private static class Bucket {
        private Integer water;
        private Integer capicity;

        public Integer getWater() {
            return water;
        }

        public void setWater(Integer water) {
            this.water = water;
        }

        public Integer getCapicity() {
            return capicity;
        }

        public void setCapicity(Integer capicity) {
            this.capicity = capicity;
        }
    }

    private static class BucketsState {
        private List<Bucket> buckets;
        private Action curAction;
    }

    private static class Action {
        private Integer from;
        private Integer to;
        private Integer water;
    }
}
