package com.codeforcommunity.api;

import com.codeforcommunity.dto.MemberReturn;
import com.codeforcommunity.dto.Result;

import java.util.List;

public interface IProcessor {
  Result createMeeting(String meetingName);

  Result checkIn(String meetingId, String email);

  //TODO: Params
  Result createMember();

  Result closeMeeting(String meetingId);

  List<MemberReturn> getAttendees();
}
