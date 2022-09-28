import Modal from './Modal.jsx';
import LessonInput from '../form/LessonInput.jsx';

function LessonModal({ onClose }) {
  return (
    <Modal onClose={onClose}>
      <LessonInput />
    </Modal>
  );
}

export default LessonModal;