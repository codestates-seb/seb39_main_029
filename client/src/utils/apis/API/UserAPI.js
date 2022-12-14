import authRequest from '../Interceptors';
import { getUser, removeUser } from '../../Localstorage';

// 서버가 role 해결해주면 url 고쳐놓기

// 내 정보 조회
async function GetUserInfo() {
  const { role, userId } = getUser();
  try {
    const result = await authRequest.get(`/v1/${role}s/myPage/${userId}`);
    return result.data;
  } catch (err) {
    console.log(err);
  }
}

async function GetUserSpec({ role, userId }) {
  try {
    const result = await authRequest.get(`/v1/${role}s/myPage/${userId}`);
    return result.data;
  } catch (err) {
    console.log(err);
  }
}

// 회원정보수정
async function PatchUserInfo({ editForm }) {
  const { role, userId } = getUser();
  try {
    const result = await authRequest.patch(`/v1/${role}s/update/${userId}`, editForm);
    return result.data;
  } catch (err) {
    console.log(err);
  }
}

// 학생회원비밀번호수정 (수정 가능성있음)
async function PatchPassword(editPasswordForm) {
  const { role, userId } = getUser();
  try {
    const result = await authRequest.patch(`/v1/${role}s/password/${userId}`, editPasswordForm);
    return result.data;
  } catch (err) {
    console.log(err);
  }
}

// 회원정보삭제
async function DeleteUserInfo() {
  const { role, userId } = getUser();
  try {
    const result = await authRequest.delete(`/v1/${role}s/delete/${userId}`);
    removeUser();
    return result.data;
  } catch (err) {
    console.log(err);
  }
}

export { GetUserInfo, GetUserSpec, PatchUserInfo, DeleteUserInfo, PatchPassword };
