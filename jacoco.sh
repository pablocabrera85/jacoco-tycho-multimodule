#!/bin/sh
dir=$(pwd)
rm -rf ${dir}/jacoco-aggregation
#first build generates the data for all modules, but only verifies coverage for tests because of how jacoco works
mvn clean verify -DreportBaseDir=${dir}
#second build has the data from the previous run so it will fail if the checks don't pass. skipping test execution as we only need to verify the jacoco data
#could be replaced by manually invoking the jacoco:check, but you need to specify goal configuration by hand.
mvn verify -DreportBaseDir=${dir} -DskipTests