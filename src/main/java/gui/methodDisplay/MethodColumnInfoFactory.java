package gui.methodDisplay;

import com.intellij.util.ui.ColumnInfo;

import core.methodStats.MethodSummary;
import java.util.Comparator;
import org.jetbrains.annotations.Nullable;

/**
 * All the column properties of the gui table are defined here.
 */
class MethodColumnInfoFactory {

    /**
     * Generates the column vector for the table model.
     *
     * @return ColumnInfo's
     */
    public ColumnInfo[] getColumnInfos() {
        return new ColumnInfo[]{
                new NameInfo(),
                new CCInfo(),
                new LOCInfo(),
                new ParamInfo(),
                new ReturnInfo()
        };
    }

    public Class[] getColumnClasses() {
        return new Class[]{NameInfo.class, CCInfo.class, LOCInfo.class,ParamInfo.class,ReturnInfo.class};
    }

    static class NameInfo extends ColumnInfo<MethodSummary, String> {

        public NameInfo() {
            super("Name");
        }

        @Nullable
        @Override
        public String valueOf(MethodSummary methodItem) {
            return methodItem.getName();
        }

        @Nullable
        @Override
        public Comparator<MethodSummary> getComparator() {
            return Comparator.comparing(o -> o.getName());
        }
    }

    static class CCInfo extends ColumnInfo<MethodSummary, String> {

        public CCInfo() {
            super("CC");
        }

        @Nullable
        @Override
        public String valueOf(MethodSummary methodItem) {
            return Integer.toString(methodItem.getCC());
        }

        @Nullable
        @Override
        public Comparator<MethodSummary> getComparator() {
            return Comparator.comparingInt(o -> o.getCC());
        }
    }

    static class LOCInfo extends ColumnInfo<MethodSummary, String> {

        public LOCInfo() {
            super("LOC");
        }

        @Nullable
        @Override
        public String valueOf(MethodSummary methodItem) {
            return Integer.toString(methodItem.getLOC());
        }

        @Nullable
        @Override
        public Comparator<MethodSummary> getComparator() {
            return Comparator.comparingInt(o -> o.getLOC());
        }
    }

    static class ParamInfo extends ColumnInfo<MethodSummary, String> {

        public ParamInfo() {
            super("Parameters");
        }

        @Nullable
        @Override
        public String valueOf(MethodSummary methodSummary) {
            return methodSummary.getParameterList();
        }

        @Nullable
        @Override
        public Comparator<MethodSummary> getComparator() {
            return Comparator.comparingInt(o -> o.getParameterSize());
        }
    }

    static class ReturnInfo extends ColumnInfo<MethodSummary, String> {

        public ReturnInfo() {
            super("Return Type");
        }

        @Nullable
        @Override
        public String valueOf(MethodSummary methodItem) {
            return methodItem.getReturnType();
        }

        @Nullable
        @Override
        public Comparator<MethodSummary> getComparator() {
            return Comparator.comparing(o -> o.getReturnType());
        }
    }
}
