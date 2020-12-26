package service;

import model.VirtualMachine;

public class VirtualMachineCreator {
    public static final String TESTDATA_CALCULATOR_TYPE = "testdata.calculator.type";
    public static final String TESTDATA_NUMBER_OF_INSTANCE = "testdata.number.of.instance";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.operating.system";
    public static final String TESTDATA_MACHINE_CLASS = "testdata.machine.class";
    public static final String TESTDATA_MACHINE_SERIES = "testdata.machine.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    public static final String TESTDATA_NUMBER_OF_GPU = "testdata.number.of.gpu";
    public static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";
    public static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    public static final String TESTDATA_DATA_CENTER = "testdata.data.center";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.committed.usage";

    public static VirtualMachine withCredentialsFromProperty(){
        return new VirtualMachine(TestDataReader.getData(TESTDATA_CALCULATOR_TYPE),
                TestDataReader.getData(TESTDATA_NUMBER_OF_INSTANCE), TestDataReader.getData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getData(TESTDATA_MACHINE_CLASS), TestDataReader.getData(TESTDATA_MACHINE_SERIES),
                TestDataReader.getData(TESTDATA_MACHINE_TYPE),TestDataReader.getData(TESTDATA_NUMBER_OF_GPU),
                TestDataReader.getData(TESTDATA_GPU_TYPE),TestDataReader.getData(TESTDATA_LOCAL_SSD),
                TestDataReader.getData(TESTDATA_DATA_CENTER),TestDataReader.getData(TESTDATA_COMMITTED_USAGE));
    }
}
