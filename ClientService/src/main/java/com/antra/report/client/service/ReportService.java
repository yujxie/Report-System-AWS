package com.antra.report.client.service;

import com.antra.report.client.pojo.FileType;
import com.antra.report.client.pojo.reponse.ReportVO;
import com.antra.report.client.pojo.reponse.SqsResponse;
import com.antra.report.client.pojo.request.ReportRequest;

import java.io.InputStream;
import java.util.List;

public interface ReportService {
    ReportVO generateReportsSync(ReportRequest request);

    ReportVO generateReportsAsync(ReportRequest request);

    ReportVO updateReportById(String reqId, ReportRequest request);

    void deleteReport(String reqId);

    void updateAsyncPDFReport(SqsResponse response);

    void updateAsyncExcelReport(SqsResponse response);

    List<ReportVO> getReportList();

    ReportVO getReportById(String reqId);

    InputStream getFileBodyByReqId(String reqId, FileType type);
}
