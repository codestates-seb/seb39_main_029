import styled from '@emotion/styled';
import Loginform from '../form/loginForm/LoginForm.jsx';
import Modal from './Modal.jsx';

function LoginModal({ onClose }) {
  return (
    <Modal onClose={onClose}>
      <Head>login.</Head>
      <Loginform onClose={onClose} />
    </Modal>
  );
}

const Head = styled.h1`
  margin: 0 0 0 20px;
  font-family: var(--point);
  font-size: var(--xl);
  font-weight: bold;
`;

export default LoginModal;
